package com.kitri.admin.main.controlPanel.BlockedSites;

import java.util.ArrayList;
import java.util.Vector;

public interface BSDaoService {
	public Vector<Vector> selectAll();
	public boolean insert(String url, String name) ;
	public boolean update(BSDto dto);
	public boolean deleteBSDto (String name);
	public BSDaoServiceImpl getBSDao (String name);
}
