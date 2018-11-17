package chen;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static List<String> objToString(List list) {
		if (list == null)
			return new ArrayList<String>(0);
		List<String> strList = new ArrayList<String>(list.size());
		for (Object obj : list) {
			strList.add(obj.toString());
		}
		return strList;
	}
}
