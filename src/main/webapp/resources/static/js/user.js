let index = {
    init: function (){
        $('#btn-login').on("click", () => {
            this.save();
        });
    },
    
    save: function (){
        // alert("버튼 클릭됨!!");
        console.log("asdfasdf");
    }
}
index.init();