package com.example.api.designpattern.DP03templateMethodPattern.externalLibrary;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer3AbstGameConnectHelper")
public abstract class AbstGameConnectHelper {
    /*유저가 게임 접속시 다음을 고려 해야 합니다.*/

    // 보안 과정 : 보안 관련 부분을 처리합니다.
    protected abstract String doSecurity(String string);

    // 인증 과정 : user name 과 password 가 일치하는지 확인 합니다.
    protected abstract boolean authentication(String id, String password);

    // 권한 과정 : 접속자가 유료 회원인지 무료회원인지 게임 마스터 인지 확인 합니다.
    protected abstract int authorization(String userName);

    // 접속 과정 : 접속자에게 커넥션을 정보를 넘겨줍니다.
    protected abstract String connection(String info);

    // 템플릿 메소드
    public String requestConnection(String encodedInfo) {
        // 보안작업 -> 암호화 된 문자열을 복호화
        String decodedInfo = doSecurity(encodedInfo);

        // 반환된 것을 가지고 아이디, 암호를 할당한다.
        String id = "aaa";
        String password = "bbb ";

        if(!authentication(id, password)) {
            System.out.println("아이디 암호 불일치");
        }

        String userName = "userName";
        int i = authorization(userName);

        switch(i) {
            case 0: // 게임 매니저
                break;
            case 1: // 유료 회원
                break;
            case 2: // 무료 회원
                break;
            case 3: //
                break;
            default:
                break;
        }

        return connection(decodedInfo);
    }
}
