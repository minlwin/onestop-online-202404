package com.jdc.online.nio;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface DistrictReader {

	Map<String, List<String>> read(Path path);
}
