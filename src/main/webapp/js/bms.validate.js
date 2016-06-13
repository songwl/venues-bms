
jQuery.validator.setDefaults({
	ignore:".ignore",
	errorElement:"label",
	errorPlacement:function(error,element) {  
		error.addClass("col-sm-4");
		error.insertAfter(element.parent()); 
	},
});

jQuery.extend(jQuery.validator.messages, {
    required: "必填字段",
	remote: "请修正该字段",
	email: "请输入正确格式的电子邮件",
	url: "请输入合法的网址",
	date: "请输入合法的日期",
	dateISO: "请输入合法的日期 (ISO).",
	number: "请输入合法的数字",
	digits: "只能输入整数",
	creditcard: "请输入合法的信用卡号",
	equalTo: "请再次输入相同的值",
	accept: "请输入拥有合法后缀名的字符串",
	maxlength: jQuery.validator.format("请输入一个长度最多是 {0} 的字符串"),
	minlength: jQuery.validator.format("请输入一个长度最少是 {0} 的字符串"),
	rangelength: jQuery.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
	range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
	max: jQuery.validator.format("请输入一个最大为 {0} 的值"),
	min: jQuery.validator.format("请输入一个最小为 {0} 的值")
});

//手机号码验证  
jQuery.validator.addMethod("mobile", function (value, element) {  
    var length = value.length;  
    var mobile = /^(1[3|7][0-9]|14[5|7]|15[0-9]|18[0-9]|170)\d{8}$/;  
    return this.optional(element) || (length == 11 && mobile.test(value));  
}, "请正确填写您的手机号码");  
  
jQuery.validator.addMethod("positive",function(value,element){
    var score = /^[0-9]*$/;
    return this.optional(element) || (score.test(value));
},"只能输入大于0的数字");
  
// 电话号码验证  
jQuery.validator.addMethod("phone", function (value, element) {  
    var tel = /^\d{3,4}-?\d{7,9}$/;    //电话号码格式010-12345678  
    return this.optional(element) || (tel.test(value));  
}, "请正确填写您的电话号码"); 

// 邮政编码验证   
jQuery.validator.addMethod("postcode", function(value, element) {   
	    var tel = /^[0-9]{6}$/;
	    return this.optional(element) || (tel.test(value));
}, "请正确填写您的邮政编码");

//日期比较验证
jQuery.validator.addMethod("compareDate", function(value, element, param) {   
	var startDate = jQuery(param).val();
	var startDatetime=startDate.trim().replace(/-/g,"");
	var endDatetime=value.trim().replace(/-/g,"");
    return startDatetime <= endDatetime;
}, "结束日期必须大于开始日期");

//数值比较
jQuery.validator.addMethod("compareNumber", function(value, element, param) {   
	var num = jQuery(param).val();
	var num1=num.trim().replace(/-/g,"");
	var num2=value.trim().replace(/-/g,"");
    return parseInt(num1) <= parseInt(num2);
}, "第二个值必须大于等于第一个值");

//英文验证
jQuery.validator.addMethod("english", function(value, element) {   
    var tel = /^([a-zA-Z0-9-_]+)$/;
    return this.optional(element) || (tel.test(value));
}, "只能用数字字母下划线");
//中文验证
jQuery.validator.addMethod("chinese", function(value, element) {   
    var tel = /^[\u4e00-\u9fa5]+$/;
    return this.optional(element) || (tel.test(value));
}, "请正确填写中文");

//身份证验证
jQuery.validator.addMethod("idCardNo", function (value, element) {
    return this.optional(element) || isIdCardNo(value);
}, "请正确输入身份证号码");

//增加身份证验证
function isIdCardNo(num) {
    var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var parityBit = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        return false;
    }
    // check and set value
    for (i = 0; i < intStrLen; i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i] * factorArr[i];
        }
    }

    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6, 14);
        if (isDate8(date8) == false) {
            return false;
        }
        // calculate the sum of the products
        for (i = 0; i < 17; i++) {
            lngProduct = lngProduct + varArray[i];
        }
        // calculate the check digit
        intCheckDigit = parityBit[lngProduct % 11];
        // check last digit
        if (varArray[17] != intCheckDigit) {
            return false;
        }
    }
    else {        //length is 15
        //check date
        var date6 = idNumber.substring(6, 12);
        if (isDate6(date6) == false) {
            return false;
        }
    }
    return true;
}

function isDate6(sDate) {
    if (!/^[0-9]{6}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    if (year < 1700 || year > 2500) return false
    if (month < 1 || month > 12) return false
    return true
}
/**
* 判断是否为“YYYYMMDD”式的时期
*
*/
function isDate8(sDate) {
    if (!/^[0-9]{8}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    day = sDate.substring(6, 8);
    var iaMonthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if (year < 1700 || year > 2500) return false
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1] = 29;
    if (month < 1 || month > 12) return false
    if (day < 1 || day > iaMonthDays[month - 1]) return false
    return true
}