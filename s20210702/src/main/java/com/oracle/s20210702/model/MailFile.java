package com.oracle.s20210702.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailFile {
	private int mail_file_no;
	private int mail_no;
	private String mail_org_name;
	private String mail_save_name;
	private long mail_size;
	private int mail_file_open;
}
