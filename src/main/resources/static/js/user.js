let index = {
    init: function (){
        $('#btn-save').on("click", () => {
            this.save();
        });
    },
    
    save: function (){
        let data ={
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#mail").val()

        }
        // console.log(data)

        $.ajax().done().fail(); // ajax 통신을 이용해서 insert 요청
    }
}
index.init();