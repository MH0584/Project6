"use strict"
const socket = io();

const commentInput = document.querySelector("#commentInput");
const writeSubmit = document.querySelector(".writeSubmit");
const chatList = document.querySelector(".childViewContainer");
const logEvent = document.querySelector(".logEvent");

// 닉네임 파라미터 받기
const urlParams = new URL(location.href).searchParams;
const pfName = urlParams.get('nickname');

// 엔터 쳤을 때 이벤트
commentInput.addEventListener("keyup", (event) => {
  if (event.keyCode === 13) {
    if (!event.shiftKey) {
      event.preventDefault(); 
      send();
      commentInput.value = "";
    }
  }
})

// 메시지 데이터 보내는 이벤트
function send() {
  const param = {
    name: pfName, // 대화명
    msg: commentInput.value // 메시지 내용
  }
  event.preventDefault(); 
  socket.emit("chatting", param);
  // commentInput.value = "";
}

// 클릭했을 때의 전송 이벤트
writeSubmit.addEventListener("click", send)

// 스크롤 데이터에 따라 늘어나게 조정, 데이터를 보냈을 때의 HTML 추가 메소드 실행
socket.on("chatting", (data)=> {
  const {name, msg, time} = data;
  const item = new DivModel(name, msg, time);
  item.makeDiv();
  chatList.scrollTo(0, chatList.scrollHeight);
})

function DivModel(name, msg, time) {
  
  this.name = name;
  this.msg = msg;
  this.time = time;

  this.makeDiv = () => {
    const div = document.createElement("div");
    div.classList.add("logWrap");
    div.classList.add(pfName === this.name ? "logMy" : "logFriend")
    const dom = `<a href="#" class="uProfile">
                  <span class="profileInner"></span>
                </a>
                <span class="pfName">
                      <button class="author">
                        ${this.name}
                      </button>
                    </span>
                <div class="msg msgContainer">
                  <div class="msgMain">
                    <div class="messageBodyWrap">
                      <span class="txt">${this.msg}</span>
                    </div>
                    <div class="aside">
                      <div class="msgAside">
                        <span class="time">${this.time}</span>
                      </div>
                    </div>
                  </div>
                </div>`;
    div.innerHTML = dom;
    chatList.appendChild(div);
  }
}