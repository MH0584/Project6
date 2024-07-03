<%@page import="dto.MeetInfoWriteDTO"%>
<%@page import="dao.MeetInfoWriteDAO"%>
<%@page import="dto.MeetIntroduceWriteDTO"%>
<%@page import="dao.MeetIntroduceWriteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int meet_idx = Integer.parseInt(request.getParameter("meet_idx"));

	MeetIntroduceWriteDAO miDao = new MeetIntroduceWriteDAO();
	MeetIntroduceWriteDTO miDto = miDao.selectMeetIntroduceWriteDTO(meet_idx);
	
	MeetInfoWriteDAO mDao = new MeetInfoWriteDAO();
	MeetInfoWriteDTO mDto = mDao.selectMeetInfoWriteDTO(meet_idx);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel='stylesheet' type='text/css' media='screen' href='../assets/css/clear.css'>
  <link rel='stylesheet' type='text/css' media='screen' href='../assets/css/band.css'>
  <link rel='stylesheet' type='text/css' media='screen' href='../assets/css/band_header.css'>
  <title>BAND - <%= miDto.getMeet_name() %></title>
  <script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
  <div id="wrap">
    <!-- 최상단 헤더 -->
    <header class="header_area bg_blue">
      <div class="headerInner">
        <!-- 로고, 검색창 영역 -->
        <div class="logo_search_area">
          <!-- 로고 -->
          <h1 class = "logo_area">
            <a href="#" class="logo">
            </a>
          </h1>
          <!-- 검색창 -->
          <form action>
            <fieldset>
              <div class="search_input">
                <input type="text" id="input_serach_view" class="inputBandSearch" role="search" placeholder="밴드, 페이지, 게시글 검색" autocomplete="off">
                <button type="submit" class="btn_search">
                </button>
              </div>
            </fieldset>
          </form>
        </div>
        <!-- 위젯 -->
        <div id="header_widget_area">
          <ul class="widgetList">
            <li>
              <button class="btnIconStyle">
                <span class="uIconNews bg_white"></span>
              </button>
            </li>
            <li class="ml_14">
              <button class="btnIconStyle">
                <span class="uIconChat bg_white"></span>
              </button>
            </li>
            <li class="ml_24 positionR">
              <button class="btnMySetting">
                <span class="uProfile">
                  <span class="profileInner">
                    <img src="	https://ssl.pstatic.net/cmstatic/webclient/dres/20240528100621/images/template/profile_60x60.png"
                    width="30" height="30">
                  </span>
                </span>
              </button>
            </li>
          </ul>
        </div>
      </div>
    </header>
    <!-- 내용 시작 -->
    <div id="container" class="band_main_area">
      <!-- header lnb 메뉴 -->
      <div class="header_lnb bg_blue">
        <ul class="header_lnb_menu">
          <li class="menu_item">
            <a href="#">
              <span class="menu_item_txt active">게시글</span>
            </a>
          </li>
          <li class="menu_item">
            <a href="#">
              <span class="menu_item_txt">멤버</span>
            </a>
          </li>
        </ul>
      </div>
      <!-- 메인 내용 왼쪽 밴드 소개 -->
      <aside class="band_info">
        <div class="info_inner">
          <div class="sticky_side_bar">
            <!-- 밴드 이미지 -->
            <div class="side_cover">
              <a href="#">
                <div class="cover_img">
                  <span class="cover_inner">
                  <img
                    <% if (miDto.getUrl() != null) {%>
                    	src = "<%= miDto.getUrl() %>"
                   	<% } %>
                   	>
                  </span>
                </div>
              </a>
              <!-- 밴드 이름 -->
              <div class="band_name">
                <a class="band_name_txt"><%= miDto.getMeet_name() %></a>
              </div>
            </div>
            <!-- 멤버 수 -->
            <p class="member">
              <a href="#" class="member_count">멤버 <%= miDto.getMeet_member_count() %></a>
            </p>
            <!-- 글쓰기 버튼 -->
            <div class="btnBox">
              <button type="submit" class="uButton" id="joinBtn">밴드 가입하기</button>
            </div>
            <div class="bandInfoBox">
              <a href="#" class="showBandInfo">밴드 정보 보기
                <span class="uIconArrow"></span>
              </a>
            </div>
            <p class="bandTypeDesc">누구나 밴드를 검색해 찾을 수 있고, 밴드 소개와 게시물을 볼 수 있습니다.</p>
          </div>
        </div>
      </aside>
      <!-- 메인 내용 게시글 목록 및 글쓰기 -->
      <main class="band_main">
        <section>
          <!-- 게시글 검색 form -->
          <div class="searchWrap">
            <form>
              <div class="inputSearch">
                <input type="text" id="input_search" placeholder="글 내용, #태그, @작성자 검색"
                maxlength="200" class="searchTxt">
                <button type="submit" class="search"></button>
              </div>
            </form>
          </div>
          <!-- 밴드 소개 영역 -->
          <div class="bandIntroRegion">
            <div class="contentsCard">
              <div class="bandIntro">
                <h2 class="bandIntroTitle">밴드 소개</h2>
                <ul class="areaSelect">
                  <li class="areaSelectItem">
                    <a href="#" class="areaButton">
                      <span class="iconLocal"></span>
                      <%= mDto.getArea() %>
                    </a>
                  </li>
                </ul>
                <div class="bandIntroDetail">
                  <p class="desc">
                    <%= mDto.getTitle() %>
                  </p>
                </div>
              </div>
            </div>
          </div>
          <!-- 게시글 목록 : 헤더 영역 -->
          <div class="boardTag">
            <div class="boardTagHead">
              <div class="sortingMenu">
                <button class="buttonSorting">최신순</button>
              </div>
            </div>
          </div>
          <!-- 게시글 목록 : 내용 영역 -->
          <div class="moduleBox">
            <!-- 게시글이 없을 경우 -->
            <div class="postWrap">
              <div>
                <div class="postEmpty">
                  <a class="emptyInnerBox" href="#">
                    <span class="emptyIcon -first"></span>
                    <em class="emptyTitle">그룹 게시판</em>
                    <p class="emptyDesc">
                      첫 게시글을 작성해보세요.<br>
                      나와 멤버가 쓴 글이 여기에 표시됩니다.
                    </p>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </section>
      </main>
    </div>
    <!-- 가입질문 팝업 -->
    <div class="layerContainerView" tabindex="-1" id="memberJoinQ_popUp" style="display: none;">
      <div class="layerContainerInnerView">
        <section class="lyWrap">
          <div class="lyContent">
            <header class="modalHeader">
              <h1 class="title">
                <%= miDto.getMeet_name() %>
                <p class="titleDesc">가입 질문에 답해주세요.</p>
              </h1>
            </header>
            <div class="modalBody">
              <div class="joinQnAArea">
                <div class="questionBox">
                  <div class="questionText">가입하시려는 이유는요?</div>
                </div>
                <div class="answerInputBox">
                  <div class="answerInputWrap">
                    <div class="mentions-input">
                      <div class="mentions">
                        <textarea maxlength="200" placeholder="답변을 작성해주세요."></textarea>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="modalFooter">
              <button class="uButton -cancle">취소</button>
              <button class="uButton -confirm">다음</button>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
  <!-- JavaScript -->
  <script>
    $(function() {
      $("#joinBtn").click(function() {
        $(".layerContainerView").css('display', 'block');
      })
      $(".-cancle").click(function() {
        $(".layerContainerView").css('display', 'none');
      })
    });
  </script>
</body>
</html>