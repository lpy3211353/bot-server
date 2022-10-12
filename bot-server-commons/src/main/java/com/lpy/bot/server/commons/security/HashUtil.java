package com.lpy.bot.server.commons.security;

import com.google.common.hash.Hashing;
import kotlin.text.Charsets;

public class HashUtil {
    public static byte[] toSha256(String message){
        return Hashing.sha256().newHasher().putString(message, Charsets.UTF_8).hash().asBytes();
    }
}
