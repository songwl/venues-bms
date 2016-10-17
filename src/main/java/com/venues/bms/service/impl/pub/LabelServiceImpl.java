package com.venues.bms.service.impl.pub;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.venues.bms.dao.PubLabelMapper;
import com.venues.bms.po.PubLabel;
import com.venues.bms.service.pub.LabelService;

@Service("labelService")
public class LabelServiceImpl implements LabelService{
	
	@Autowired
	private PubLabelMapper pubLabelMapper;

	@Override
	public List<PubLabel> queryByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return pubLabelMapper.selectByParams(params);
	}

	@Override
	public int saveLabel(String label) {
		Map<String, Object> params = new HashMap<>();
		params.put("label", label);
		List<PubLabel> list = pubLabelMapper.selectByParams(params);
		if(!CollectionUtils.isEmpty(list)){
			return 0;
		}
		PubLabel pubLabel = new PubLabel();
		pubLabel.setLabel(label);
		pubLabel.setCreateTime(new Date());
		return pubLabelMapper.insert(pubLabel);
	}
	
	

}
