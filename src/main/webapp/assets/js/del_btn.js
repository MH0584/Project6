document.addEventListener("DOMContentLoaded", function() {

    const con = document.querySelectorAll(".style_input")

    // 인풋 태그에 입력이 발생할 때
    con.forEach(function(con) {

        var input = con.querySelector('.con_input');
        var clearButton = con.querySelector('.del_btn');

        input.addEventListener('input', function() {
        if (input.value.length > 0) {
            clearButton.style.display = 'block';
        } else {
            clearButton.style.display = 'none';
        }
        });

        // span 태그를 클릭하면 인풋 태그의 값을 초기화
        clearButton.addEventListener('click', function() {
        input.value = '';
        clearButton.style.display = 'none';
        });
    });

});
