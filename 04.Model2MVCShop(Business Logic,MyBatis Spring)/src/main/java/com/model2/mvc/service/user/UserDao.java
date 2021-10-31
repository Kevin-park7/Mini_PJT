package com.model2.mvc.service.user;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.User;


//==> ȸ���������� CRUD �߻�ȭ/ĸ��ȭ�� DAO Interface Definition
public interface UserDao {
	
	// INSERT
	public void addUser(User user) throws Exception ;
	//������ user�� �޾ƿ� insert�� �ϰ� ��� ���� ���� �ʰڴ� void

	// SELECT ONE
	public User getUser(String userId) throws Exception ;
	//userId��� String���� �޾ƿͼ� ������ ��ȸ�ϰ� User��� �����ο� ��Ƽ� ������� ���� ���
	//list�� ��Ƽ� ���� �ʱ� ������ �������� �޾ƿ� �� ���� �ϳ��� ������ �޾� �ϳ��� ������ ���
	
	// SELECT LIST
	public List<User> getUserList(Search search) throws Exception ;
	//select�� ������ü�� ��ȸ�ϰ� �װ���� search�� ��Ƽ� list�������̽��� User�� �������� ��Ƽ� ���� ������ ���

	// UPDATE
	public void updateUser(User user) throws Exception ;
	//user�����ο� ������ ���� �޾ƿ� �����͸� �����Ѵ�. �׷��� void�̱� ������ ��� ���� ����
	
	// �Խ��� Page ó���� ���� ��üRow(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	//
	
}