package com.venues.bms.service.theme;

import java.util.List;
import java.util.Map;

import com.venues.bms.po.TmTheme;

public interface ThemeService {

	List<TmTheme> findThemeList(Map<String, Object> params);

}
