package gs;


import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	public static final String SECRET = "d3780ec3d1cfaba271e0538d4fae686d8367e10155ee424691fbf191eabec53d";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
	    try {
	        return Jwts.parserBuilder()
	                   .setSigningKey(getSignKey())
	                   .build()
	                   .parseClaimsJws(token)
	                   .getBody();
	    } catch (Exception e) {
	        throw new RuntimeException("Invalid JWT token", e);
	    }
	}
	public List<String> extractRoles(String token) {
	    Claims claims = extractAllClaims(token);
	    return claims.get("roles", List.class);
	}


	public Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}

