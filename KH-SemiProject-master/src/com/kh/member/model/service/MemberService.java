package com.kh.member.model.service;

import java.util.Properties;
import java.util.Random;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	static int  AuthenticationKey;
	
	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		// 성공하면 1, 실패하면 0 리턴
		if(result > 0) { // 성공했다면
			JDBCTemplate.commit(conn);
		}
		else { // 실패했다면
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int inquirySandEmil(String mail,String title) {
		//보내는 사람 계정정보
		String host = "smtp.gmail.com";
		String user = "koddol1898@gmail.com"; // 자신의 구글 계정
		String password = "hh741852aa!";// 자신의 구글 패스워드
		//받는사람 계정정보
		String to_email = mail;
	
		
		//SMTP 서버 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		
		
		//랜덤변수 만들기
		Random rnd = new Random(System.currentTimeMillis());
		long start = System.currentTimeMillis();
		int bound=900000;
		int result=100000+rnd.nextInt(bound);
		AuthenticationKey = result;
			
		//세션설정
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		//메일보내기
		try { 
			
			MimeMessage message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email)); 
			// 메일 제목 
			message.setSubject("북적북적에서 알립니다.."); 
			// 메일 내용
			message.setText("고객님의 문의 '"+ title +"'에 답변이 달렸습니다."); 
			//send the message 
			Transport.send(message);
			System.out.println("Success Message Send for certification "); 
			return 0;
			}
		catch (MessagingException e) { 
			e.printStackTrace(); 
			return 1;
			}
	}
	
	public int mailSend(String mail) {
		//보내는 사람 계정정보
		String host = "smtp.gmail.com";
		String user = "koddol1898@gmail.com"; // 자신의 구글 계정
		String password = "hh741852aa!";// 자신의 구글 패스워드
		//받는사람 계정정보
		String to_email = mail;
	
		
		//SMTP 서버 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		
		
		//랜덤변수 만들기
		Random rnd = new Random(System.currentTimeMillis());
		long start = System.currentTimeMillis();
		int bound=900000;
		int result=100000+rnd.nextInt(bound);
		AuthenticationKey = result;
			
		//세션설정
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		//메일보내기
		try { 
			
			MimeMessage message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email)); 
			// 메일 제목 
			message.setSubject("북적북적 이메일 인증 메일입니다."); 
			// 메일 내용
			message.setText("인증번호는 " + AuthenticationKey+" 입니다."); 
			//send the message 
			Transport.send(message);
			System.out.println("Success Message Send for certification "); 
			return 0;
			}
		catch (MessagingException e) { 
			e.printStackTrace(); 
			return 1;
			}
	}
	public int checkNum(String num) {
		String key=String.valueOf(AuthenticationKey);
		if(num.equals(key)) {
			return 0;
		}
		else {
			return 1;
		}
		
	}
	public int idCheck(String checkId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
	
	
	public int findId(String userName, String phone,String email) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new MemberDao().findId(conn,userName,phone,email);
		
		if(result.isEmpty()) {
			return 1;//찾는 아이디가 없을경우
				
		}
		else {
			String[] stringArr= {result,"아이디","ID"};
			int mailSandResult = sandFindingEmail(userName,email,stringArr);
			
			if (mailSandResult>0) {
				return 2; //찾았지만 메일 전송 실패할경우
			}
			else {
				return 0; //찾았고 메일전송 성공
			}
		}
	}
	public int findPw( String id, String userName,String email) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new MemberDao().findPw(conn,id,userName,email);
		
		if(result.isEmpty()) {
			return 1;//찾는 비밀번호 없을경우
				
		}
		else {
			String[] stringArr= {result,"비밀번호","PW"};
			int mailSandResult = sandFindingEmail(userName,email,stringArr);
			
			if (mailSandResult>0) {
				return 2; //찾았지만 메일 전송 실패할경우
			}
			else {
				return 0; //찾았고 메일전송 성공
			}
		}
	}
		
		
	
	public int sandFindingEmail(String userName,String mail, String[] result) {
			//보내는 사람 계정정보
			String host = "smtp.gmail.com";
			String user = "koddol1898@gmail.com"; // 자신의 구글 계정
			String password = "hh741852aa!";// 자신의 구글 패스워드
			//받는사람 계정정보
			String to_email = mail;
		
			
			//SMTP 서버 설정
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true"); 
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			
			//세션설정
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			//메일보내기
			try { 
				
				MimeMessage message = new MimeMessage(session); 
				message.setFrom(new InternetAddress(user));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email)); 
				// 메일 제목 
				message.setSubject("북적북적에서 고객님의 "+result[1]+"를 찾았습니다!!."); 
				// 메일 내용
				message.setText(userName+"님의 "+result[1]+"는 " + result[0]+" 입니다."); 
				//send the message 
				Transport.send(message);
				System.out.println("Success Message Send for Finding "+result[2]); 
				return 0;
				}
			catch (MessagingException e) { 
				e.printStackTrace(); 
				return 1;
				}
	}
	public int deleteMember(String id,String pw) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn,id,pw);
		
		// 성공하면 1, 실패하면 0 리턴
		if(result > 0) { // 성공했다면
			JDBCTemplate.commit(conn);
		}
		else { // 실패했다면
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	public Member login(String id,String pw) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().login(conn,id,pw);
		
		// 3) Connection 객체 반납
				JDBCTemplate.close(conn);
				
				// 4) Controller 로 결과 넘기기
		return m;
	}
	public Member updatePwdMember(String userId, String userPwd, String updatePwd) {
		
		Connection conn = JDBCTemplate.getConnection();

		int result = new MemberDao().updatePwdMember(conn, userId, userPwd, updatePwd);
		
		// 호출 결과에 따라서 성공이면 commit 후에 새로 바뀐 회원의 정보를 다시 받아온다.
		Member updateMem = null;
		
		if(result > 0) { // 성공
			JDBCTemplate.commit(conn);
			
			// 갱신된 회원 객체를 다시 받아오기
			updateMem = new MemberDao().selectMember(conn, userId);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return updateMem;
	}
	
	   public Member updateMember(Member m) {
		      
		      Connection conn = JDBCTemplate.getConnection();
		      
		      int result = new MemberDao().updateMember(conn, m);
		      Member updateMem = null;
		      if(result > 0) {
		         
		         JDBCTemplate.commit(conn);
		         updateMem = new MemberDao().selectMember(conn, m.getUserId());
		      }
		      else { 
		         
		         JDBCTemplate.rollback(conn);
		      }
		      
		      JDBCTemplate.close(conn);
		      
		      return updateMem;
		      
		   }

	
	public Member checkPwdMember(String userId, String checkPwd) {
		
		Connection conn = JDBCTemplate.getConnection();

		Member checkMem = new MemberDao().checkPwdMember(conn, userId, checkPwd);
		
		// 3) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 4) Controller 로 결과 넘기기
		return checkMem;
		
	}
	
	
}
