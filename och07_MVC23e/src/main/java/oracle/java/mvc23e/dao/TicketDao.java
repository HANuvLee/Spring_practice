package oracle.java.mvc23e.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import oracle.java.mvc23e.dto.TicketDto;

public class TicketDao {

	JdbcTemplate template;
	
//	PlatformTransactionManager transactionManager;
	TransactionTemplate transactionTemplate1;
	
	public void setTemplate(JdbcTemplate template) { 
		this.template = template;
	}
	
//	public void setTransactionManager( PlatformTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}
	
	public void setTransactionTemplate1(TransactionTemplate transactionTemplate) {
		this.transactionTemplate1 = transactionTemplate;
	}
	
	public TicketDao() {
		System.out.println(template);
	}
	
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		                                  // 익명 Class
		transactionTemplate1.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con)
							throws SQLException {
						String query = "insert into card (consumerId, amount) values (?, ?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						
						return pstmt;
					}
				});
				
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con)
							throws SQLException {
						String query = "insert into ticket (consumerId, countnum) values (?, ?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						
						return pstmt;
					}
				});
			}
		});
		
//		TransactionDefinition definition = new DefaultTransactionDefinition();
//		TransactionStatus status = transactionManager.getTransaction(definition);
		
//		try {
//		
//			
//		
//			transactionManager.commit(status);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//			transactionManager.rollback(status);
//		}
	}

	
}
