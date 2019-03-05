package m2.eservices.alloetudiant.config;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864_000_000;
    public static final String  SECRET = "alloetudiantsecret";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final int TOKEN_EXPIRATION = 60 * 48;
}
