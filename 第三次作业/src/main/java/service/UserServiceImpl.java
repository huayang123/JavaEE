package service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	public void insert() {
		System.out.println("插入");
	}

	public void delete() {
		System.out.println("删除");
	}

	public void update() {
		System.out.println("修改");
	}

	public void find() {
		System.out.println("查找");
	}

}
