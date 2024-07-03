const express = require("express");
const http = require("http");
const app = express();
const path = require("path");
const server = http.createServer(app);
const socketIO = require("socket.io");
const moment = require("moment");

const io = socketIO(server);

// 서버 실행 시 보여주는 파일
app.use(express.static(path.join(__dirname, "/")))
const PORT = process.env.PORT || 3000;

io.on("connection", (socket) => {
  socket.on("chatting", (data) => {  // 채팅 아이디
    const { name, msg } = data;
    io.emit("chatting", {
      name,
      msg,
      time : moment(new Date()).format("h:mm A"),
    })
  })
});

server.listen(PORT, ()=>console.log(`server is running ${PORT}`))