package com.oracle.s20210702.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail_File {
	private int mail_file_no;
	private int mail_no;
	private String mail_org_name;
	private String mail_save_name;
	private long mail_file_size;
	private int mail_file_open;
	
	//================게시판 첨부파일용====================
	private int project_no;
	private int board_no;
}
