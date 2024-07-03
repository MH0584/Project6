<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel='stylesheet' type='text/css' media='screen' href='../assets/css/clear.css'>
  <link rel='stylesheet' type='text/css' media='screen' href='../assets/css/band.css'>
  <link rel='stylesheet' type='text/css' media='screen' href='../assets/css/band_header.css'>
  <title>BAND - 내부</title>
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
                    <img src="https://ssl.pstatic.net/cmstatic/webclient/dres/20240528100621/images/template/profile_60x60.png"
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
                    <img>
                  </span>
                </div>
              </a>
              <!-- 밴드 이름 -->
              <div class="band_name">
                <a class="band_name_txt">6조 밴드</a>
              </div>
            </div>
            <!-- 멤버 수 -->
            <p class="member">
              <a href="#" class="member_count">멤버 1</a>
            </p>
            <!-- 밴드 소개 설정 -->
            <div class="band_info_setting">
              <a href="#" class="band_setting_link">밴드 소개 설정</a>
            </div>
            <!-- 글쓰기 버튼 -->
            <div class="btnBox">
              <button class="uButton bg_blue" id="postWriteBtn">글쓰기</button>
            </div>
            <!-- 밴드 안내 문구 -->
            <p class="bandTypeDesc">
              밴드와 게시글이 공개되지 않습니다. 초대를 통해서만 가입할 수 있습니다.
            </p>
            <!-- 밴드 설정 -->
            <div class="bandSetting">
              <a href="#" class="bandSetting_Link">
                <span class="uIconSetting"></span>
                밴드 설정
              </a>
            </div>
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
          <!-- 글쓰기 영역 -->
          <div class="writeWrap">
            <div class="postWrite">
              <button class="postWriteEventWrapper"></button>
              <div class="postWriteForm">
                <div class="contentEditor">새로운 소식을 남겨보세요.</div>
              </div>
              <div class="buttonArea">
                <ul class="toolbarList">
                  <li class="toolbarListItem">
                    <button>
                      <span class="photoIcon"></span>
                    </button>
                  </li>
                </ul>
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
            <!-- 게시글 -->
            <div class="postWrap">
              <div class="postListView">
                <!-- 게시글 1 (사진 없는 버전) -->
                <div class="postLayoutView">
                  <article class="contentsCard">
                    <!-- 게시글 상단 -->
                    <div class="postListItemView">
                      <div class="postAuthorRegion">
                        <div class="postWriter">
                          <a href="#" class="uProfile -leader">
                            <span class="profileInner"></span>
                          </a>
                          <div class="postWriterInfoWrap">
                            <span class="name">
                              <a href="#" class="text">치이카와</a>
                            </span>
                            <div class="postListInfoWrap">
                              <time class="time">지금막</time>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="postMain">
                        <div class="postBody">
                          <div class="postTextView">
                            <div class="postText">
                              <p class="txtBody">안녕하세요~</p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 게시글 옵션 -->
                    <div class="postOptionListView">
                      <div class="postFunction">
                        <button class="postSet">글 옵션</button>
                      </div>
                    </div>
                    <!-- 게시글 하단 -->
                    <div class="postCountView">
                      <div class="postCount">
                        <!-- 댓글, 좋아요수 -->
                        <div class="postCountLeft">
                          <span class="faceComment">
                            <button class="uEmotionView">
                              <span class="emotionWrap">
                                <span class="icon">
                                  <span class="uFaceIcon"></span>
                                </span>
                              </span>
                              <span class="count">0</span>
                            </button>
                            <button class="comment">댓글<span class="count">0</span>
                            </button>
                          </span>
                        </div>
                        <!-- 조회수 -->
                        <div class="postCountRight">
                          <span class="shareRead">
                            <span class="read">
                              <span class="count">
                                2
                              </span>
                            </span>
                          </span>
                        </div>
                      </div>
                      <!-- 댓글 쓰기, 좋아요 버튼 -->
                      <div class="postAdded">
                        <div class="postAddBox">
                          <div class="addCol">
                            <button class="addStatus">
                              <span class="uFaceIcon"></span>
                              <span>좋아요
                              </span>
                            </button>
                          </div>
                          <div class="addCol">
                            <button class="addStatus">
                              <span class="uIconComment"></span>
                              <span>댓글쓰기</span>
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 댓글 내용 -->
                    <div class="commentMainView">
                      <div>
                        <!-- 댓글 목록 -->
                        <div class="commentList">
                          <div class="cComment">
                            <div>
                              <div class="itemWrap">
                                <div class="writeInfo">
                                  <a href="#" class="uProfile">
                                    <span class="profileInner">
                                      <img src="https://coresos-phinf.pstatic.net/a/371f31/9_i62Ud018svcju2od2y1er48_ezuzx0.png?type=s75"
                                      width="34" height="34">
                                    </span>
                                  </a>
                                  <button class="nameWrap">
                                    <strong class="name">장예원</strong>
                                  </button>
                                </div>
                                <div class="commentBody">
                                  <p class="txt">반갑읍니다 ㅋㅅㅋ</p>
                                  <div class="func">
                                    <time class="time" title="2024년 6월 1일 오후 3:40">3시간 전</time>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- 댓글 입력창 -->
                      <div class="cCommentWrite">
                        <section class="commentInputView">
                          <div class="writeMain">
                            <div class="writeBtn">
                              <div class="btnUploadWrap">
                                <button class="btnUpload">
                                  <span class="uIconCommentPlus"></span>
                                </button>
                              </div>
                            </div>
                            <div class="writeWrap">
                              <div class="flexBox">
                                <div class="profileStatus profileInputRegion">
                                  <div class="messageInputProfileView">
                                    <span class="current uProfile">
                                      <span class="profileInner">
                                        <img
                                        width="21" height="21">
                                      </span>
                                    </span>
                                  </div>
                                </div>
                                <div class="mentionsWrap">
                                  <div class="uInputComment">
                                    <div class="mentions-input">
                                      <div class="mentions">
                                        <div></div>
                                      </div>
                                      <textarea cols="20" rows="1" class="commentWrite" placeholder="댓글을 남겨주세요."></textarea>
                                      <div style="position: absolute; display: none; overflow-wrap: break-word; 
                                      white-space: pre-wrap; border-color: rgb(68, 68, 68);
                                      border-style: none; border-width: 0px; font-weight: 400; width: 333px;
                                      line-height: 20.02px; font-size: 13px; padding: 8px 15px 0px 10px;">&nbsp;</div>
                                    </div>
                                  </div>
                                </div>
                                <button class="btnSticker">
                                  <span class="uIconCommentSticker"></span>
                                </button>
                              </div>
                            </div>
                            <!-- 댓글 submit -->
                            <div class="submitWrap">
                              <button type="submit" class="writeSubmit">보내기</button>
                            </div>
                          </div>
                        </section>
                      </div>
                    </div>
                  </article>
                </div>
                <!-- 게시글 2 (사진 있는 버전) -->
                <div class="postLayoutView">
                  <article class="contentsCard">
                    <!-- 게시글 상단 -->
                    <div class="postListItemView">
                      <div class="postAuthorRegion">
                        <div class="postWriter">
                          <a href="#" class="uProfile -leader">
                            <span class="profileInner"></span>
                          </a>
                          <div class="postWriterInfoWrap">
                            <span class="name">
                              <a href="#" class="text">치이카와</a>
                            </span>
                            <div class="postListInfoWrap">
                              <time class="time">지금막</time>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="postMain">
                        <div class="postBody">
                          <div class="postTextView">
                            <div class="postText">
                              <p class="txtBody">안녕하세요~</p>
                            </div>
                            <div class="postPhoto">
                              <ul class="photoCollage">
                                <li class="collageItem">
                                  <button class="collageImg">
                                    <img src="https://coresos-phinf.pstatic.net/a/371ffi/f_460Ud018svc11ftqgy2zsi15_ezuzx0.png?type=ff500_750">
                                  </button>
                                </li>
                              </ul>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 게시글 옵션 -->
                    <div class="postOptionListView">
                      <div class="postFunction">
                        <button class="postSet">글 옵션</button>
                      </div>
                    </div>
                    <!-- 게시글 하단 -->
                    <div class="postCountView">
                      <div class="postCount">
                        <!-- 댓글, 좋아요수 -->
                        <div class="postCountLeft">
                          <span class="faceComment">
                            <button class="uEmotionView">
                              <span class="emotionWrap">
                                <span class="icon">
                                  <span class="uFaceIcon"></span>
                                </span>
                              </span>
                              <span class="count">0</span>
                            </button>
                            <button class="comment">댓글<span class="count">0</span>
                            </button>
                          </span>
                        </div>
                        <!-- 조회수 -->
                        <div class="postCountRight">
                          <span class="shareRead">
                            <span class="read">
                              <span class="count">
                                2
                              </span>
                            </span>
                          </span>
                        </div>
                      </div>
                      <!-- 댓글 쓰기, 좋아요 버튼 -->
                      <div class="postAdded">
                        <div class="postAddBox">
                          <div class="addCol">
                            <button class="addStatus">
                              <span class="uFaceIcon"></span>
                              <span>좋아요
                              </span>
                            </button>
                          </div>
                          <div class="addCol">
                            <button class="addStatus">
                              <span class="uIconComment"></span>
                              <span>댓글쓰기</span>
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 댓글 내용 -->
                    <div class="commentMainView">
                      <div>
                        <!-- 댓글 목록 -->
                        <div class="commentList">
                          <div class="cComment">
                            <div>
                              <div class="itemWrap">
                                <div class="writeInfo">
                                  <a href="#" class="uProfile">
                                    <span class="profileInner">
                                      <img src="https://coresos-phinf.pstatic.net/a/371f31/9_i62Ud018svcju2od2y1er48_ezuzx0.png?type=s75"
                                      width="34" height="34">
                                    </span>
                                  </a>
                                  <button class="nameWrap">
                                    <strong class="name">장예원</strong>
                                  </button>
                                </div>
                                <div class="commentBody">
                                  <p class="txt">반갑읍니다 ㅋㅅㅋ</p>
                                  <div class="func">
                                    <time class="time" title="2024년 6월 1일 오후 3:40">3시간 전</time>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- 댓글 입력창 -->
                      <div class="cCommentWrite">
                        <section class="commentInputView">
                          <div class="writeMain">
                            <div class="writeBtn">
                              <div class="btnUploadWrap">
                                <button class="btnUpload">
                                  <span class="uIconCommentPlus"></span>
                                </button>
                              </div>
                            </div>
                            <div class="writeWrap">
                              <div class="flexBox">
                                <div class="profileStatus profileInputRegion">
                                  <div class="messageInputProfileView">
                                    <span class="current uProfile">
                                      <span class="profileInner">
                                        <img
                                        width="21" height="21">
                                      </span>
                                    </span>
                                  </div>
                                </div>
                                <div class="mentionsWrap">
                                  <div class="uInputComment">
                                    <div class="mentions-input">
                                      <div class="mentions">
                                        <div></div>
                                      </div>
                                      <textarea cols="20" rows="1" class="commentWrite" placeholder="댓글을 남겨주세요."></textarea>
                                      <div style="position: absolute; display: none; overflow-wrap: break-word; 
                                      white-space: pre-wrap; border-color: rgb(68, 68, 68);
                                      border-style: none; border-width: 0px; font-weight: 400; width: 333px;
                                      line-height: 20.02px; font-size: 13px; padding: 8px 15px 0px 10px;">&nbsp;</div>
                                    </div>
                                  </div>
                                </div>
                                <button class="btnSticker">
                                  <span class="uIconCommentSticker"></span>
                                </button>
                              </div>
                            </div>
                            <!-- 댓글 submit -->
                            <div class="submitWrap">
                              <button type="submit" class="writeSubmit">보내기</button>
                            </div>
                          </div>
                        </section>
                      </div>
                    </div>
                  </article>
                </div>
              </div>
            </div>
          </div>
        </section>
      </main>
      <!-- 메인 내용 오른쪽 채팅방 목록 -->
      <div id="banner">
        <div id="bannerInner">
          <div class="chatSticky">
            <section class="bandChannerView">
              <h2 class="tit">채팅</h2>
              <div class="chat_setting_wrap">
                <button class="chat_setting_btn">설정</button>
              </div>
              <div class="body">
                <div class="new_chatting_wrap">
                  <div class="buttonBox">
                    <button class="newChattingBtn">
                      <span class="iconPlusSquare"></span>
                      새 채팅
                    </button>
                  </div>
                </div>
                <!-- 채팅 목록 -->
                <div class="nano">
                  <div class="nano_content">
                    <ul class="chat">
                      <li>
                        <button class="itemLink" onclick="window.open('chat.html', '', 'width=415, height=643')">
                          <span class="thum">
                            <img src="https://ssl.pstatic.net/cmstatic/webclient/dres/20240603162344/images/template/multi_profile_60x60.png"
                            height="30" width="30">
                          </span>
                          <span class="cont">
                            <strong class="text">치이카와, 장예원</strong>
                            <span class="sub">장예원 : ㅎㅇ</span>
                          </span>
                        </button>
                      </li>
                      <li>
                        <button class="itemLink">
                          <span class="thum">
                            <img src="https://coresos-phinf.pstatic.net/a/34g065/e_5a2Ud018admg69oqx3t5mng_5ksoqj.png?type=s75"
                            height="30" width="30">
                          </span>
                          <span class="cont">
                            <strong class="text">6조 밴드</strong>
                            <span class="sub">밴드 전체 멤버들과 함께 하는 채팅방</span>
                          </span>
                        </button>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </section>
            <!-- 사진 목록 -->
            <div class="photoBox">
              <section class="photoList photo">
                <h2 class="tit">최근 사진</h2>
                <div class="body">
                  <div class="list">
                    <!-- 이미지 있을 경우 -->
                    <a href="#" data-index="0">
                      <img src="	https://coresos-phinf.pstatic.net/a/371ffi/f_460Ud018svc11ftqgy2zsi15_ezuzx0.png?type=s150"
                      width="73" height="73">
                    </a>
                    <!-- 이미지 없는 경우 -->
                    <span class="noImg"></span>
                    <span class="noImg"></span>
                    <span class="noImg"></span>
                    <span class="noImg"></span>
                    <span class="noImg"></span>
                  </div>
                </div>
                <a href="#" class="more">더보기</a>
              </section>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 팝업 : 글쓰기 -->
    <div class="layerContainerView" tabindex="-1" id="postWriteEditor_popUp" style="display: none;">
      <div class="layerContainerInnerView">
        <div class="postEditorLayerView" style="position: relative;">
          <section class="lyWrap">
            <div class="lyPostShareWrite" style="margin-top: 77px;">
              <header class="header">
                <h1 class="title">글쓰기</h1>
              </header>
              <div class="main">
                <div class="postWrite">
                  <div class="postWriteForm">
                    <div class="contentEditor cke_editable">
                      <p></p>
                    </div>
                  </div>
                  <div class="buttonArea">
                    <ul class="toolbarList">
                      <li class="toolbarListItem">
                        <label class="photo">
                          <input type="file">
                          <svg class="svgIcon">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#ico-p-photo"></use>
                          </svg>
                        </label>
                      </li>
                    </ul>
                    <div class="writeSubmitBox">
                      <div class="buttonSubmit">
                        <button type="submit" class="uButton">게시</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <footer class="footer">
                <button class="btnLyClose"></button>
              </footer>
            </div>
          </section>
        </div>
      </div>
    </div>
    <!-- 팝업 : 새 채팅 -->
    <div class="layerContainerView" id="newChatWrap_popUp" style="display: none;">
      <div class="layerContainerInnerView">
        <section class="lyWrap">
          <div class="lyContent -w400">
            <header class="header">
              <h1 class="title">공개채팅방 만들기</h1>
            </header>
            <div class="main -tSpaceNone">
              <label for="chatName" class="title -sub2" style="margin-top: 20px">
                채팅방 이름
              </label>
              <div class="uInput" style="height: 36px; padding: 0 10px; margin-bottom: 20px;">
                <input type="text" placeholder="채팅방 이름을 입력해주세요.">
                <span class="border"></span>
              </div>
            </div>
            <footer class="footer">
              <button class="uButton -confirm -sizeL">완료</button>
              <button class="btnLyClose"></button>
            </footer>
          </div>
        </section>
      </div>
    </div>
  </div>
  <!-- JavaScript -->
  <script>
    $(function() {
      $(".postWriteEventWrapper").click(function() {
        $("#postWriteEditor_popUp").css('display', 'block');
      })
      $("#postWriteBtn").click(function() {
        $("#postWriteEditor_popUp").css('display', 'block');
      })
      $(".newChattingBtn").click(function() {
        $("#newChatWrap_popUp").css('display', 'block');
      })
      $(".btnLyClose").click(function() {
        $(".layerContainerView").css('display', 'none');
      })
    });
  </script>
</body>
</html>