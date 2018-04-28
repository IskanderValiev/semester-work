package ru.isko.services;

public interface SystemService {

    void sendLink(Long userId);
    void generateTempPassword(Long userId);
    void resetPassword(String link);
}
