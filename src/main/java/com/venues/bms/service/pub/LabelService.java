package com.venues.bms.service.pub;

import java.util.List;
import java.util.Map;

import com.venues.bms.po.PubLabel;

public interface LabelService {
	
	List<PubLabel> queryByParams(Map<String,Object> params);
	
	int saveLabel(String label);

}
