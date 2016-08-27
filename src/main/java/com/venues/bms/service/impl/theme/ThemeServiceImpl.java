package com.venues.bms.service.impl.theme;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.dao.TmThemeMapper;
import com.venues.bms.po.TmTheme;
import com.venues.bms.service.theme.ThemeService;

@Service
public class ThemeServiceImpl implements ThemeService {

	@Autowired
	private TmThemeMapper tmThemeMapper;

	@Override
	public List<TmTheme> findThemeList(Map<String, Object> params) {
		return tmThemeMapper.selectByParams(params);
	}

}
