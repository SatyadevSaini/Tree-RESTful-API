package com.incapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Tree;
import com.incapp.repo.TreeREPO;

@Service
public class TreeImplements implements TreeService {
	
	@Autowired
	TreeREPO repo;

	@Override
	public String addTree(Tree tree, MultipartFile image) {
		// TODO Auto-generated method stub
		return repo.addTree(tree, image);
	}

	@Override
	public List<Tree> getAllTrees() {
		// TODO Auto-generated method stub
		return repo.getAllTrees();
	}

	@Override
	public List<Integer> getAllIdTrees() {
		// TODO Auto-generated method stub
		return repo.getAllIdTrees();
	}

	@Override
	public String deleteID(int id) {
		// TODO Auto-generated method stub
		return repo.deleteID(id);
	}

	@Override
	public byte[] getImage(int id) {
		// TODO Auto-generated method stub
		return repo.getImage(id);
	}

	@Override
	public String UpdatewithImage(Tree tree, MultipartFile image) {
		// TODO Auto-generated method stub
		return repo.UpdatewithImage(tree, image);
	}

}
