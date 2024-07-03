<%@page import="dao.MeetIntroduceWriteDAO"%>
<%@page import="dto.MeetIntroduceWriteDTO"%>
<%@page import="dao.MybandDAO"%>
<%@page import="dto.MybandDTO"%>
<%@page import="project.DatabaseUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int m_idx = Integer.parseInt(request.getParameter("member_idx"));

	// 내 가입 밴드 출력
	MeetIntroduceWriteDAO mbwDao = new MeetIntroduceWriteDAO();
	
	MybandDAO mbDao = new MybandDAO();

	ArrayList<MybandDTO> mbListDao = new ArrayList<>();

	try { 
		mbListDao = mbDao.selectMybandDTO(m_idx);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../assets/css/band_main.css">
  <link rel="stylesheet" href="../assets/css/clear.css">
  <link rel="stylesheet" href="../assets/css/band_header.css"> 
  <title>BAND - 메인 페이지</title>
</head>
<body>
  <div class="wrap">
    <header class="header_area">
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
                <span class="uIconNews"></span>
              </button>
            </li>
            <li class="ml_14">
              <button class="btnIconStyle">
                <span class="uIconChat"></span>
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
  </div>
  <!-- 내 밴드 소모임 버튼  -->
  <div class="header2_area">
    <div id="content"> 
      <div id="content_tab" >
        <div id="content_tab_left">
          <div id="tab_myband">
            <div id="myband_btn">
              <a href = "#" class = "myband_text">
              내 밴드  
              </a>
            </div>
          </div>
          <div id="tab_meet">
            <div id="meet_btn">
              <a href="#" class="meet_text">
                소모임
              </a>
            </div>
          </div>
        </div>
        <!-- 동네 밴드 목록편집 버튼 -->
        <div id="content_tab_right">
          <!-- <div id="tab_list_edit">
            <img src="/assets/img/list_edit.png">
            <a href="#" class="list_edit_text">목록 편집</a>
          </div> -->
          <div id="tab_place_band">
            <a href="#" class="btn_option" target="_blank">
              <span class="local_icon"></span>
              <span class="option_text">동네 밴드</span>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="wrap">
    <!-- main 메인 -->
    <div id="main">
      <ul id="band_card_list">
        <li class="band_card_item">
          <div id="band_inner">
            <a href="#" class="band_create_link">
              <div id="cover">
                <img class="create_band_img">
              </div>
              <div id="band_name">
                <a class="url_text">만들기</a>
              </div>
            </a>
          </div>
        </li>
        <!-- 내 밴드 목록 -->
        <% 
        for (MybandDTO mbDto : mbListDao) {
       	%>
        <li class="band_card_item">
          <div id="band_inner">
            <a href="#" class="band_cover_link">
            <div id="cover_band">
              <div class="uCoverImage -border">
                <span class="coverInner">
                  <img class="coverImg" src="https://coresos-phinf.pstatic.net/a/362iaf/2_bjbUd018svc11thlaza5db29_d46snt.png?type=cover_a264" alt>
                </span>
              </div>
            </div>
            <div id="band_name">
              <p class="url_text"> <%= mbDto.getMeet_name() %> </p>
              <span class="member">
                멤버
                  <em><%= mbDto.getMeet_member_count() %></em>
               </span>
            </div>
            </a>
          </div>
        </li>
        <%
        }
        %>
      </ul>
    </div>
  <!-- 소모임 메인 화면 -->
    <div id="main2">
      <div id="local_meet_band">
        <h2 id="local_title">
          <span class="setting_local">홍제동</span>
          소모임
          <button type="button" class="open_keyword_btn">지역 선택</button>
          <button type="button" class="recruit_btn">모집하기</button>
        </h2>
      </div>
      <div id="content2">
        <h3 class="title_main_home">소모임 멤버를 모집합니다!
          <span class="help_guide_round" role="alert" aria-live="assertive" style="position:static">
            <button type="button" class="help_btn">
              <span class="help">도움말</span>
            </button>
            <span class="bubble_help_layer" style="width:348px; display:none">
              소모임 활동 주제가 분명하고, 오프라인 정모 활동이 활발한 밴드를 선정해 보여드려요!
              <button type="button" class="close_btn">
            </div>
              <span class="help">닫기</span>
            </button>
          </span>
        </span>
      </h3>
    
    <!-- 소모임 멤버 모집글 -->
    <div id="band_find_wrap">
        <div id="band_list">
          <div id="band_item_view">
            <div id="band_meet_content">
              <div id="band_meet_content_text">
                <h3 class="band_meet_content_title">1파크골프 라운딩 나가실분을 찾습니다
                </h3>
                <div class="band_meet_content_main">안녕하세요 작년부터 취미삼아 클럽활동하면서 주변분들께 파크골프을 소개하는 밴드을 만들어봅니다 많은분들이 파크골프와 함께 하였으면 합니다
                </div>
                <div id="band_meet_content_tag">
                  <button class="local_tag">연희동</button>
                </div>
              </div>
              <div id="band_meet_content_img">
                <img src="https://coresos-phinf.pstatic.net/a/34g0j0/b_fa2Ud018adm10u2w62ocihzm_5ksoqj.png?type=cover_a264" class="band_cover_img">
              </div>
              <a href="#" class="band_meet_content_link"></a>
            </div>
            <div id="band_meet_info_wrap">
              <div id="meet_info_box">
                <div id="meet_together">
                  <span class="-emphasis">42</span>
                  명 참여중
                </div>
              </div>
            </div>
          </div>
          <div id="band_item_view">
            <div id="band_meet_content">
              <div id="band_meet_content_text">
                <h3 class="band_meet_content_title">*당구로 친목 도모합시다*
                </h3>
                <div class="band_meet_content_main">소일거리로 당구을 치고있습니다.연희동 남가좌동 홍은동 근처 혼자 게임하기 적적하신 분은 함께 친목 도모하며 게임합시다. 제가 자주가는 게임장은 백련시장 OK당구장 입니다. 퇴직후 오시는분들이많아 연령대가 많은분들이지만 편안히 게임 할수있습니다. 오셔서함께 한게임합시다.
                </div>
                <div id="band_meet_content_tag">
                  <button class="local_tag">연희동</button>
                </div>
              </div>
              <div id="band_meet_content_img">
                <img src="https://coresos-phinf.pstatic.net/a/2ih02d/b_j6hUd018adm1l0s618835kad_fql4mk.jpg?type=cover_a264" class="band_cover_img">
              </div>
              <a href="#" class="band_meet_content_link"></a>
            </div>
            <div id="band_meet_info_wrap">
              <div id="meet_info_box">
                <div id="meet_together">
                  <span class="-emphasis">57</span>
                  명 참여중
                </div>
              </div>
            </div>
          </div>
          <div id="band_item_view">
            <div id="band_meet_content">
              <div id="band_meet_content_text">
                <h3 class="band_meet_content_title">공연홀릭(공연,뮤지컬,연극,콘서트,전시...)공연 보러가요.
                </h3>
                <div class="band_meet_content_main">뮤지컬 연극 콘서트 공연 좋아하시는 분들 함께 문화생활해요.
                </div>
                <div id="band_meet_content_tag">
                  <button class="local_tag">홍제동</button>
                </div>
              </div>
              <div id="band_meet_content_img">
                <img src="https://coresos-phinf.pstatic.net/a/35hd7b/i_hf8Ud018svc3so0rp2bqbtl_co8uf6.jpg?type=cover_a264" class="band_cover_img">
              </div>
              <a href="#" class="band_meet_content_link"></a>
            </div>
            <div id="band_meet_info_wrap">
              <div id="meet_info_box">
                <div id="meet_together">
                  <span class="-emphasis">68</span>
                  명 참여중
                </div>
              </div>
            </div>
          </div>
          <div id="band_item_view">
            <div id="band_meet_content">
              <div id="band_meet_content_text">
                <h3 class="band_meet_content_title">연희락
                </h3>
                <div class="band_meet_content_main">함께 맛깔스런 음식점 가서 대화하고, 즐기기, 등산도 하고, 영화 감상, 뮤지컬도 관람, 국내외 여행
                </div>
                <div id="band_meet_content_tag">
                  <button class="local_tag">연희동</button>
                </div>
              </div>
              <div id="band_meet_content_img">
                <img src="https://coresos-phinf.pstatic.net/a/34g065/e_5a2Ud018admg69oqx3t5mng_5ksoqj.png?type=cover_a264" class="band_cover_img">
              </div>
              <a href="#" class="band_meet_content_link"></a>
            </div>
            <div id="band_meet_info_wrap">
              <div id="meet_info_box">
                <div id="meet_together">
                  <span class="-emphasis">28</span>
                  명 참여중
                </div>
              </div>
            </div>
          </div>
          <div id="band_item_view">
            <div id="band_meet_content">
              <div id="band_meet_content_text">
                <h3 class="band_meet_content_title">남가좌동 당나귀 독서모임
                </h3>
                <div class="band_meet_content_main">책을 주제로 편하게 소통할수 있는 공간입니다. 누구나 참여가능하고 어려운 주제를 다루지 않습니다. 하지만 특정 주제에 대해 다양한 관점을 공유합니다~
                </div>
                <div id="band_meet_content_tag">
                  <button class="local_tag">남가좌동</button>
                </div>
              </div>
              <div id="band_meet_content_img">
                <img src="https://coresos-phinf.pstatic.net/a/36ch0e/c_690Ud018svcpd39zwazvmzs_byb7eh.jpg?type=cover_a264" class="band_cover_img">
              </div>
              <a href="#" class="band_meet_content_link"></a>
            </div>
            <div id="band_meet_info_wrap">
              <div id="meet_info_box">
                <div id="meet_together">
                  <span class="-emphasis">137</span>
                  명 참여중
                </div>
              </div>
            </div>
          </div>
          <div id="band_item_view">
            <div id="band_meet_content">
              <div id="band_meet_content_text">
                <h3 class="band_meet_content_title">뚜벅뚜벅  걸어요
                </h3>
                <div class="band_meet_content_main">안녕하세요 
                  걷는거 만큼 좋은 운동도 없는듯 싶어요
                  나 혼자 걷는 걷기 운동도 좋구
                  함게 걷는 운동도 좋찮아요
                  기회되면 함게 뚜벅뚜벅 걸어요
                </div>
                <div id="band_meet_content_tag">
                  <button class="local_tag">신촌동</button>
                </div>
              </div>
              <div id="band_meet_content_img">
                <img src="https://coresos-phinf.pstatic.net/a/3679cg/7_14bUd018svc18hnktiqlahox_flckfa.jpg?type=cover_a264" class="band_cover_img">
              </div>
              <a href="#" class="band_meet_content_link"></a>
            </div>
            <div id="band_meet_info_wrap">
              <div id="meet_info_box">
                <div id="meet_together">
                  <span class="-emphasis">126</span>
                  명 참여중
                </div>
              </div>
            </div>
          </div>
      </div>
    </div>
      <!-- footer -->
    </div>
  </div>
  <footer id="footer">
      <div id="footer_wrap">
        <ul class="menu_list">
          <li class="menu_list_item">
            <a href="#" target="_blank" class="menu_link">블로그</a>
          </li>
          <li class="menu_list_item">
            <a href="#" target="_blank" class="menu_link">이용약관</a>
          </li>
          <li class="menu_list_item">
            <a href="#" target="_blank" class="menu_link">
              <strong>개인정보처리방침</strong>
            </a>
          </li>
        </ul>
        <address>
          <strong>BAND</strong>
          © 2024
        </address>
      </div>
  </footer>
</body>
</html>