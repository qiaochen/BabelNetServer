package chen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelNetQuery;
import it.uniroma1.lcl.babelnet.BabelSense;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.BabelSynsetComparator;
import it.uniroma1.lcl.babelnet.data.BabelGloss;
import it.uniroma1.lcl.babelnet.data.BabelExample;
import it.uniroma1.lcl.jlt.util.Language;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import chen.Utils;


public class SenseFetcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String word = req.getParameter("term");
		BabelNet bn = BabelNetServer.bn;
		resp.setContentType("json;charset=utf-8");
		resp.setStatus(HttpStatus.OK_200);
		if (word != null) {
			BabelNetQuery query = new BabelNetQuery.Builder(word).from(Language.EN).build();
			List<BabelSynset> synsets = bn.getSynsets(query);
			Collections.sort(synsets, new BabelSynsetComparator(word));
			List<SynsetPojo> pojos = new ArrayList<SynsetPojo>(synsets.size());
			for (BabelSynset synset : synsets) {
				String bnid = synset.getID().toString();
				String type = synset.getType().toString();
				String pos = synset.getPOS().toString();
				Boolean isKeyConcept = synset.isKeyConcept();
				String main_sense = synset.getMainSense(Language.EN).toString();
				String main_gross = synset.getMainGloss(Language.EN).toString();
				List<String> wnids = Utils.objToString(synset.getWordNetOffsets());
				List<String> categories = Utils.objToString(synset.getCategories(Language.EN));
				List<String> grosses = Utils.objToString(synset.getGlosses(Language.EN));
				List<String> examples = Utils.objToString(synset.getExamples(Language.EN));
				List<SensePojo> senses = new ArrayList<SensePojo>();
				for (BabelSense sense : synset.getSenses(Language.EN)) {
					senses.add(new SensePojo(sense.toString(), sense.isKeySense(), sense.getPOS().toString(),
							sense.getSensekey(), sense.getID()));
				}
				pojos.add(new SynsetPojo(senses, grosses, bnid, wnids, main_sense, main_gross, categories, examples,
						type, pos));
			}
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			resp.getWriter().println(ow.writeValueAsString(pojos));
		}
		resp.getWriter().println("No word found!");

	}
}
