package com.venues.bms.web.venue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.VeVenue;
import com.venues.bms.service.venue.VenueService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/7.
 */
@Controller
@RequestMapping(value = "/venue")
public class VenueController extends BaseController {

	@Autowired
	private VenueService venueService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<VeVenue> page = new Page<>(1, 10);
		Map<String, Object> params = new HashMap<>();
		page = venueService.findVenuePage(page, params);
		model.put("page", page);
		return "venue/list";
	}
}
