<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li>
          <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Danh mục
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
             <li>
                    <a href='<c:url value="/admin-user?type=list&page=1&maxPageItem=2&sortName=user_id&sortBy=asc"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý tài khoản
                    </a>
                    <b class="arrow"></b>
                </li>
            	<li>
                    <a href='<c:url value="/admin-club?type=list&page=1&maxPageItem=2&sortName=club_name&sortBy=asc"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý câu lạc bộ
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href='<c:url value="/admin-announcement?type=list&page=1&maxPageItem=2&sortName=title&sortBy=asc"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý thông báo
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href='<c:url value="/admin-event?type=list&page=1&maxPageItem=2&sortName=event_id&sortBy=desc"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý hoạt động/sự kiện
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href='<c:url value="/admin-member?type=list&page=1&maxPageItem=2&sortName=last_name&sortBy=asc"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý thành viên
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Xử lý yêu cầu
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
             <li>
                    <a href='<c:url value="/admin-requestlist?type=list&page=1&maxPageItem=5&sortName=status&sortBy=asc"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Đăng ký câu lạc bộ
                    </a>
                    <b class="arrow"></b>
                </li>
            	<li>
                    <a href='<c:url value="/admin-memberevent?type=list&page=1&maxPageItem=5&sortName=status&sortBy=asc"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Tham gia hoạt động
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>