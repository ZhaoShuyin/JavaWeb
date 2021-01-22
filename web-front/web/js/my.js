
// 去左空格;
function ltrim(s) {
	return s.replace(/^\s*/, "");
}
// 去右空格;
function rtrim(s) {
	return s.replace(/\s*$/, "");
}
// 左右空格;
function trim(s) {
	return rtrim(ltrim(s));
}

// 如果是去掉半角和全角空格就把 \s 替换成 [" "|" "] 就变成
// 去左空格;
function ltrimq(s) {
	return s.replace(/^[" "|"　"]*/, "");
}
// 去右空格;
function rtrimq(s) {
	return s.replace(/[" "|"　"]*$/, "");
}
// 左右空格;
function trimq(s) {
	return rtrimq(ltrimq(s));
}