package z.f.enumerate;

/**
 * @author z
 * */
enum UserStatus {
    /**
     * 用户标识为一的时候用户禁用
     * */
    DISABLE(1),ENABLE(0);
    /**
     * 用户标识为0的时候用户启用
     * */


    private int status;

    private UserStatus(Integer i) {
        this.status = i;
    }

    public Integer getStatus() {
        return status;
    }
}
