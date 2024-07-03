document.addEventListener('DOMContentLoaded', function() {

    /* 월 별 조회 드롭다운 기능 */
    var selectLinks = document.querySelectorAll('.select.ng-binding');
    
    selectLinks.forEach(function(link) { 
        link.addEventListener('click', function(event) {
            event.preventDefault();
            
            var parentDiv = this.parentElement; 
            var list = this.nextElementSibling;
            /* 선택한 박스의 보더가 검정으로 바뀌게 */
            if (parentDiv.classList.contains('binding')) { 
                parentDiv.classList.remove('binding'); 
                parentDiv.classList.add('acting');
            } else {
                parentDiv.classList.remove('acting'); 
                parentDiv.classList.add('binding'); 
            }
            /* 박스를 클릭하면 리스트가 펼쳐지게 */
            if (list.classList.contains('ng-hiding')) {
                list.classList.remove('ng-hiding');
            } else {
                list.classList.add("ng-hiding");
            }
        });
    });

    /* 월 별 조회 해당 옵션 선택시 텍스트 바뀌는 기능 */
    var selectList = this.querySelectorAll(".ng-scope");
    selectList.forEach(function(select) {
        select.addEventListener("click", function(event){
            event.preventDefault();

            const choiceText = this.textContent;
            this.parentElement.parentElement.querySelector(".select.ng-binding").textContent = choiceText;
            
            /* 박스의 보더색깔 원래대로 */
            const close_border = this.closest(".selectbox.acting");
            if(close_border.classList.contains("acting")) {
                close_border.classList.remove("acting");
                close_border.classList.add('binding');
            } else {
                    close_border.classList.add("acting");
                }
            /* 리스트가 다시 닫히게 */
            const close_list = this.parentElement.parentElement.querySelector(".select_list");
            close_list.classList.add('ng-hiding');   
            /* 바로 옆에 박스 리스트 자동으로 열리게 */
            const siblingDiv = this.closest("div").nextElementSibling;
            siblingDiv.classList.remove("binding");
            siblingDiv.classList.add("acting");
            const siblingDivList = this.closest("div").nextElementSibling.querySelector(".select_list");
            siblingDivList.classList.remove("ng-hiding");
        })
    })
});

/* jQuery */
$(document).ready(function() {

    /* 월 별 조회 드롭다운 기능 */
    var selectLinks = $('.select.ng-binding');
    
    selectLinks.each(function() { 
        $(this).on('click', function(event) {
            event.preventDefault();
            
            var parentDiv = $(this).parent(); 
            var list = $(this).next();
            /* 선택한 박스의 보더가 검정으로 바뀌게 */
            if (parentDiv.hasClass('binding')) { 
                parentDiv.removeClass('binding'); 
                parentDiv.addClass('acting');
            } else {
                parentDiv.removeClass('acting'); 
                parentDiv.addClass('binding'); 
            }
            /* 박스를 클릭하면 리스트가 펼쳐지게 */
            if (list.hasClass('ng-hiding')) {
                list.removeClass('ng-hiding');
            } else {
                list.addClass("ng-hiding");
            }
        });
    });

    /* 월 별 조회 해당 옵션 선택시 텍스트 바뀌는 기능 */
    var selectList = $(".ng-scope");
    selectList.each(function() {
        $(this).on("click", function(event){
            event.preventDefault();

            const choiceText = $(this).text();
            $(this).closest(".selectbox").find(".select.ng-binding").text(choiceText);
            
            /* 박스의 보더색깔 원래대로 */
            const close_border = $(this).closest(".selectbox.acting");
            if(close_border.hasClass("acting")) {
                close_border.removeClass("acting");
                close_border.addClass('binding');
            } else {
                close_border.addClass("acting");
            }
            /* 리스트가 다시 닫히게 */
            const close_list = $(this).closest(".selectbox").find(".select_list");
            close_list.addClass('ng-hiding');   
            /* 바로 옆에 박스 리스트 자동으로 열리게 */
            const siblingDiv = $(this).closest(".selectbox").next();
            siblingDiv.removeClass("binding");
            siblingDiv.addClass("acting");
            const siblingDivList = siblingDiv.find(".select_list");
            siblingDivList.removeClass("ng-hiding");
        });
    });
});
