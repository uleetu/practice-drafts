package org.ko.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode {

    /**
     * 验证码生产构造函数
     * @param image 验证图片
     * @param code 验证编码
     * @param expireTime 生成时间
     */
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 验证码验证构造函数
     * @param image 验证图片
     * @param code 验证编码
     * @param expireIn 有效时间 5/s 单位(秒)
     */
    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    /**
     * 图片验证码
     */
    private BufferedImage image;

    /**
     * 验证码code
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}