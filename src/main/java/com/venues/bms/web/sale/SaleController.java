package com.venues.bms.web.sale;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.po.TmTheme;
import com.venues.bms.service.sale.SaleService;
import com.venues.bms.service.theme.ThemeService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/7/24.
 */
@Controller
@RequestMapping(value = "/sale")
public class SaleController extends BaseController {

	@Autowired
	private SaleService saleService;

	@Autowired
	private ThemeService themeService;

	@RequestMapping(value = "/themeList")
	public String list(ModelMap model) throws Exception {
		Map<String, Object> params = this.getSearchRequest();

		List<TmTheme> list = themeService.findThemeList(params);
		model.put("list", list);
		return "sale/theme_list";
	}

	@RequestMapping(value = "/themeSales/{id}")
	public String themeSales(ModelMap model, @PathVariable Integer id) throws Exception {
		Map<String, Object> params = this.getSearchRequest();

		List<TmTheme> list = themeService.findThemeList(params);
		model.put("list", list);
		return "sale/theme_list";
	}

}
