package com.quanlyclb.model;

public class StatusModel {
	// Yêu cầu tham gia vừa được khởi tạo (đang chờ duyệt)
	public final int INIT = 1;
	// Yêu cầu tham gia được duyệt
	public final int ACCEPTED = 2;
	// Thành viên đã rời clb
	public final int FINISHED = 3;
	// Hủy yêu cầu tham gia
	public final int CANCEL = -1;	
}
