package chen;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelSense;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.BabelSynsetComparator;
import it.uniroma1.lcl.jlt.util.Language;

public class SenseFetcherServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String word = req.getParameter("term");
		BabelNet bn = BabelNetServer.bn;
		resp.setStatus(HttpStatus.OK_200);
		if (word != null) {
			StringBuilder sb = new StringBuilder();
			List<BabelSynset> synsets = bn.getSynsets(word, Language.EN);
			Collections.sort(synsets, new BabelSynsetComparator(word));
			for (BabelSynset synset : synsets)
			{
				sb.append("  =>(" + synset.getID() + 
								 "; TYPE: " + synset.getType() +
								 "; WN SYNSET: " + synset.getWordNetOffsets() + ";\n" +
								 "  MAIN LEMMA: " + synset.getMainSense(Language.EN) +
//								 ";\n  IMAGES: " + synset.getImages() +
								 ";\n  CATEGORIES: " + synset.getCategories(Language.EN) +
								 ";\n  SENSES: { \n");
				for (BabelSense sense : synset.getSenses(Language.EN)) {
					sb.append(sense.toString()+" "+sense.getPronunciations()+" ");
					sb.append("\n");
					sb.append(sense.getFullLemma());
				}
				sb.append("}\n  -----\n");
			}
			resp.getWriter().println(sb.toString());
		}
		resp.getWriter().println("No word found!");
		
	}
}
