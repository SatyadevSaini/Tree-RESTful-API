package com.incapp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Tree;

public interface TreeService {

	public String addTree(Tree tree , MultipartFile image);
	public List<Tree> getAllTrees();
	public List<Integer> getAllIdTrees();
	public String deleteID(int id);
	public byte[] getImage(int id);
	public String UpdatewithImage(Tree tree , MultipartFile image);
	
}
