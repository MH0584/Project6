document.addEventListener("DOMContentLoaded", function() {

    // 가입완료 버튼에 약간 효과 주기
    var btn = document.querySelector(".btn.point");
    if(btn) {
    btn.addEventListener("mousedown", function() {
        btn.classList.add("special");
    });
    btn.addEventListener("mouseup", function() {
        btn.classList.remove("special");
    });
    btn.addEventListener("mouseleave", function() {
        btn.classList.remove("special");
    });
    } else {
        console.log("못찾음")
    }

    // 이메일 박스 리스트에 있는거 선택 기능
    var emailInputs = document.querySelectorAll('.text_email');
    var emailDomainSelects = document.querySelectorAll('.list_email');

    emailDomainSelects.forEach(function(select, index) {
        select.addEventListener('change', function() {
            var selectedDomain = select.value;
            var emailInput = emailInputs[index];
        
            if (selectedDomain === 'direct') {
                emailInput.value = '';  // 직접 입력 선택하면 초기화
            } else {
                var emailParts = emailInput.value.split('@');
                emailInput.value = emailParts[0] + '@' + selectedDomain;
            }
            emailInput.dispatchEvent(new Event('input')); 
        });
    });

    // 모든 인풋의 값 입력할 때까지 인증번호 버튼 disabled
    let inputs = document.querySelectorAll(".input_text");
    let submitButton = document.querySelector('.btn.border_type');
    
    function validateInputs() {
        let userid = document.getElementById("input_id").value;
        let password = document.getElementById("input_pw").value;
        let confirmPassword = document.getElementById("input_pw_confirm").value;
        let name = document.getElementById("input_name").value;
        let nickname = document.getElementById("input_nickname").value;
        let email = document.getElementById("input_email").value;
        let phone = document.getElementById("input_phone").value;
        let address = document.getElementById("input_address").value;
        let detail_ad = document.getElementById("input_addressDetailed").value;
        let birth = document.getElementById("input_birth").value;
        let gender = document.getElementById("input_gender").value;

        let useridValid = /^[a-zA-Z0-9]{6,20}$/.test(userid);
        let passwordValid = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(password);
        let confirmPasswordValid = password === confirmPassword;
        let nameValid = /^[가-힣]{2,}$/.test(name);
        let nicknameValid = /^[가-힣a-zA-Z]{2,10}$/.test(nickname);
        let emailValid = /^[^\s@]+@[^\s@]+\.com$/.test(email);
        let phoneValid = /^[0-9]{10,11}$/.test(phone);
        let addressValid = address != '';
        let detail_adValid = detail_ad != '';
        let birthValid = /^.{6,}$/.test(birth);
        let genderValid = /^[1234]+$/.test(gender);

        return useridValid && passwordValid && confirmPasswordValid && nameValid && nicknameValid && emailValid && phoneValid && addressValid && detail_adValid && birthValid && genderValid;
    }

    function updateButtonState() {
        if (validateInputs()) {
            submitButton.classList.add("notdisabled"); // 버튼 활성화
        } else {
            submitButton.classList.remove("notdisabled"); // 버튼 비활성화
        }
    }

    inputs.forEach(input => {
    input.addEventListener('input', updateButtonState);
    });
    updateButtonState();

     // 모든 인풋의 값 입력할 때까지 법정대리인 버튼 disabled
    let inputsP = document.querySelectorAll(".input_text.agree");
    let submitButtonP = document.querySelector('.btn.border_type.sType');
    
    function validateInputsP() {
        let name = document.getElementById("input_name_p").value;
        let email = document.getElementById("input_email_p").value;

        let nameValid = name.trim() !== '';
        let emailValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

        return nameValid && emailValid;
    };

    function updateButtonStateP() {
        if (validateInputsP()) {
            submitButtonP.classList.add("notdisabled")  // 버튼이 선명해짐
        } else {
            submitButtonP.classList.remove("notdisabled") // 버튼이 선명해짐
        }
    };
    
    inputsP.forEach(input => {
        input.addEventListener('input', updateButtonStateP);
        console.log("이벤트 리스너 추가됨:", input);
    
    });

    // 휴대폰 인증번호 받으면 모든 인풋 readonly로 바꾸기(보류)
    document.querySelector(".btn.border_type").addEventListener("click", function() {
        let inputs1 = document.querySelectorAll('input[type="text"]');
        let inputs2 = document.querySelectorAll('input[type="password"]');
        let vali_box = document.querySelector(".account_vali");
        let certify = document.getElementById("certify");

        // // text 인풋 비활성화
        // inputs1.forEach(function(input) {
        // input.setAttribute('readonly', true);
        // });
        // // password 인풋 비활성화
        // inputs2.forEach(function(input) {
        // input.setAttribute('readonly', true);
        // });
        
        vali_box.style.display = "block"; // 이미 가입된 정보면 박스 나옴
        certify.style.display = "block"; // 그 인증번호 인풋하고 타이머 나옴
    });

    // 체크박스 파란색 활성화 
    var labels = document.querySelectorAll(".text");
    var box = document.querySelectorAll(".checkbox input")

    labels.forEach(function(label, index) {
        label.addEventListener("click", function() {
            box[index].checked = !box[index].checked
        })
    });

    // 14세 미만가입시 열리는 블럭 
    document.getElementById("child").addEventListener("click", function() {
    var child_text = document.querySelector(".uError_text");
    var child_box1 = document.querySelector(".content_wrapper .uBlock:nth-child(15)")
    var child_box2 = document.querySelector(".content_wrapper .uBlock:nth-child(16)")
    var child_box3 = document.querySelector(".content_wrapper .uBlock:nth-child(17)")
        if (child_text.style.display == "block") {
            child_text.style.display = "none"
            child_box1.style.display = "none"
            child_box2.style.display = "none"
            child_box3.style.display = "none"
        } else {
            child_text.style.display = "block"
            child_box1.style.display = "block"
            child_box2.style.display = "block"
            child_box3.style.display = "block"
        }
    });
    
    // 삭제버튼 기능
    const con = document.querySelectorAll(".input_box")

    con.forEach(function(con) {

        var input = con.querySelector('.input_text');
        var clearButton = con.querySelector('.del_btn');

        input.addEventListener('input', function() {
        if (input.value.length > 0) {
            clearButton.style.display = 'block';
        } else {
            clearButton.style.display = 'none';
        }
        });

    clearButton.addEventListener('click', function() {
        input.value = '';
        clearButton.style.display = 'none';
        });
    });

    // 인증번호가 같아야 버튼 활성화되게끔
    var sentV = "123456";
    document.getElementById("check_certify").addEventListener("click", function() {
        var input = document.getElementById("input_certify").value;

        if (input === sentV) {
            alert("인증이 완료되었습니다");
            document.getElementById("input_certify").setAttribute("readonly", true);
            let final = document.querySelector(".btn.point");
            final.disabled = false;
            final.style.backgroundColor = "#fa2828";
        } else {
            alert("인증번호가 일치하지 않습니다")
        }  
    })

    // 아이디 에러창
    document.getElementById("input_id").addEventListener('input', function() {
        const regex = /^[a-zA-Z0-9]{6,20}$/;
        const errorEl = this.closest('.uBlock').querySelector('.error_text');
        const isValid = regex.test(this.value);
        errorEl.style.display = isValid ? 'none' : 'block';
    });
    // 비밀번호 에러창
    document.getElementById("input_pw").addEventListener('input', function() {
        const regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        const errorEl = this.closest('.uBlock').querySelector('.error_text');
        const isValid = regex.test(this.value);
        errorEl.style.display = isValid ? 'none' : 'block';
    });
    // 비밀번호 확인 에러창
    document.getElementById("input_pw_confirm").addEventListener('input', function() {
        const pw = document.getElementById("input_pw").value;
        const errorEl = this.closest('.uBlock').querySelector('.error_text');
        const isValid = this.value === pw;
        errorEl.style.display = isValid ? 'none' : 'block';
        errorEl.innerText = isValid ? '' : '비밀번호와 일치하지 않습니다.';
    });
    // 이름 에러창
    document.getElementById("input_name").addEventListener('input', function() {
        const regex = /^[가-힣]{2,}$/;
        const errorEl = this.closest('.uBlock').querySelector('.error_text');
        const isValid = regex.test(this.value);
        errorEl.style.display = isValid ? 'none' : 'block';
    });
    // 닉넴 에러창
    document.getElementById("input_nickname").addEventListener('input', function() {
        const regex = /^[가-힣a-zA-Z]{2,10}$/;
        const errorEl = this.closest('.uBlock').querySelector('.error_text');
        const isValid = regex.test(this.value);
        errorEl.style.display = isValid ? 'none' : 'block';
    });

    // document.getElementById("input_email").addEventListener('input', function() {
    //     const regex = /^[^\s@]+@[^\s@]+\.com$/;
    //     const errorEl = this.closest('.uBlock').querySelector('.error_text');
    //     const isValid = regex.test(this.value);
    //     errorEl.style.display = isValid ? 'none' : 'block';
    // });
    document.getElementById("input_email").addEventListener('change', function() {
        validateEmail();
    });
    document.getElementById("email").addEventListener('change', function() {
        validateEmail();
    });
    function validateEmail() {
        const emailInput = document.getElementById('input_email').value;
        const domainSelect = document.getElementById('email').value;
        const fullEmail = emailInput + domainSelect;
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        const errorEl = document.getElementById('input_email').closest('.uBlock').querySelector('.error_text');
        const isValid = regex.test(fullEmail);
        errorEl.style.display = isValid ? 'none' : 'block';
    }
    // 폰번호 에러창
    document.getElementById("input_phone").addEventListener('input', function() {
        const regex = /^[0-9]{10,11}$/;
        const errorEl = this.closest('.uBlock').querySelector('.error_text');
        const isValid = regex.test(this.value);
        errorEl.style.display = isValid ? 'none' : 'block';
    });
});