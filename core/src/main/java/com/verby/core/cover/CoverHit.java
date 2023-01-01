package com.verby.core.cover;

import com.verby.core.config.database.RedisHashKey;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.HashSet;
import java.util.Set;

@Getter
@RedisHash(value = RedisHashKey.COVER_HIT)
public class CoverHit {
    @Id
    private Long id;
    private Set<String> requestIPs = new HashSet<>();

    public CoverHit(Long id) {
        this.id = id;
    }

    public void hit(String requestIP) {
        requestIPs.add(requestIP);
    }
}