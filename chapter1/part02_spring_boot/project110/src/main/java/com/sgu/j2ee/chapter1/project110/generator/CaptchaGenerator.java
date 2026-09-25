package com.sgu.j2ee.chapter1.project110.generator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

public class CaptchaGenerator {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 70;

    private static final String CHARACTERS =
            "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) throws IOException {

        File outputDir = new File("src/main/resources/static/images/captcha");
        if (!outputDir.exists()) {
            // Khi chạy từ thư mục gốc của repository (j2ee_exercise)
            outputDir = new File("chapter1/part02_spring_boot/project110/src/main/resources/static/images/captcha");
        }
        outputDir.mkdirs();

        for (int i = 1; i <= 20; i++) {

            String captchaText = generateCaptchaText(5);

            // Ảnh đang tồn tại trong ram
            BufferedImage image = createCaptchaImage(captchaText);

            File outputFile = new File(outputDir, "captcha" + i + ".png");

            ImageIO.write(image, "png", outputFile);

            System.out.println(
                    "captcha" + i + ".png -> " + captchaText
            );
        }

        System.out.println("Đã tạo xong 20 CAPTCHA.");
    }

    private static String generateCaptchaText(int length) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {

            int index = RANDOM.nextInt(CHARACTERS.length());

            result.append(CHARACTERS.charAt(index));
        }

        return result.toString();
    }

    private static BufferedImage createCaptchaImage(String text) {

        BufferedImage image = new BufferedImage(
                WIDTH,
                HEIGHT,
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D graphics = image.createGraphics();

        // Background
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        // Noise lines, tạo hiệu ứng nhiễu cho bức ảnh
        for (int i = 0; i < 10; i++) {

            graphics.setColor(randomColor());

            int x1 = RANDOM.nextInt(WIDTH);
            int y1 = RANDOM.nextInt(HEIGHT);
            int x2 = RANDOM.nextInt(WIDTH);
            int y2 = RANDOM.nextInt(HEIGHT);

            graphics.drawLine(x1, y1, x2, y2);
        }

        // CAPTCHA text
        graphics.setFont(
                new Font("Arial", Font.BOLD, 36)
        );

        for (int i = 0; i < text.length(); i++) {

            graphics.setColor(randomColor());

            int x = 20 + i * 32;
            int y = 45 + RANDOM.nextInt(10);

            graphics.drawString(
                    String.valueOf(text.charAt(i)),
                    x,
                    y
            );
        }

        // Noise dots
        for (int i = 0; i < 100; i++) {

            graphics.setColor(randomColor());

            int x = RANDOM.nextInt(WIDTH);
            int y = RANDOM.nextInt(HEIGHT);

            graphics.fillOval(x, y, 2, 2);
        }

        graphics.dispose();

        return image;
    }

    private static Color randomColor() {

        return new Color(
                RANDOM.nextInt(150),
                RANDOM.nextInt(150),
                RANDOM.nextInt(150)
        );
    }
}