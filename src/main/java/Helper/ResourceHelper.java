package Helper;

import java.nio.file.Path;

public class ResourceHelper {

	public static String getResourcePath (String path) {
		String basePath=System.getProperty("user.dir");
		return basePath+path;
	}
	
	}
