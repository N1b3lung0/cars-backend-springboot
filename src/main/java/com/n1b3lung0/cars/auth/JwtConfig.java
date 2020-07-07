package com.n1b3lung0.cars.auth;

public class JwtConfig {

    public static final String SECRET_KEY = "alguna.clave.secreta.12345678";

    public static final String PRIVATE_RSA = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAzOvsshbTbyfRldkc2fAu4OuXHikUiADUj7c1x8eVryj0a7hS\n" +
            "wRtTMaVdrBr9UcUtUTN87zEPUeHw1rFWpdb0SpfvgoOZjj6eAd4O2ZR/ZGADof+9\n" +
            "P1zYira5kcyBhjNAr6pBIhEvMUY8x6Z5dVXWx/AkanrMY9nvanyuXPd7Yxl3mwJl\n" +
            "VRe2bQS/9qqJZmfxYXKaYq6adu9kZJ54DYEYrQIgfBWIZ57HTeN1q5+KnJFF+HFE\n" +
            "jwIY6lhQ7a7/PhfRY4m2tkcK2Ekf6Hr6biqR+AIUR411nH8eTMqznJQLTVIfTdB/\n" +
            "I/ggANhXJ/tIoUmlK95VyKlBSi4CjiYqpt8G0QIDAQABAoIBABBk03PP5axf2CGP\n" +
            "1AIPeACgeF9+U9kpj9fLhW7tJal0slEn1t8CC57OJvdM1XVEPALiBp2wJBSd6cGT\n" +
            "QGZWEwcgrpWXZ6J8mfF2TWPUwHhMQh4ksoQuLliyk5f5b2dIFGW5Tiqmi0r63oPu\n" +
            "aosbiepG6PLnzhAy8DdpsB1Z4zIjQ8stvWP1jGnGc50N1y88mL8SeWZebcLSSKyy\n" +
            "feC7IQHggK7vxXBH6Dl717DeeQXwGEfG1MEYZZCnmFQ2q4JwM6Z5d7XRBh/b8urr\n" +
            "5Q7XjRltqsrlQU/Q6jgZogJi/vb7P4P0WVvDUfb/emp4jQCGHXHG/+OqBV5VXMd5\n" +
            "lZrzD80CgYEA5yET9+8EEYiICc39a4b1DO+KmMDhf8Tnoz5UYl81sXnhe4RXfP+m\n" +
            "nu930PfoyOqZkwP7nmfWLrNFLv9Ifp97NsVGKtJSvXKNpoLpb3ISBimB8gSy0E/F\n" +
            "gHyU6HFoiRrhmZrOwLN8QNxk6K5za4baWWR3jdrk4D3HXGyzNJMP0Z8CgYEA4vjn\n" +
            "g9M1RIqBbcXHhTxglUOChVN9tImAbj4C3ejWeafyFbyXNXGSR6XZ4t90dG5Jnr8v\n" +
            "EW32nMXiy2tMyLtWC2ymXQCtdQz2E9fIt+sfh//HQ5UgEU0zx6hG4LNMpRwEfh8E\n" +
            "zgJ+CIg7TyFZy/YaC6yfY0OPf3NK6OKXSNymsY8CgYEArOrjbJ+mdJOn62XwTe0X\n" +
            "Esl38JaFXrjq8AemzD4dBp1/44/8gGknuErCYlXHE+HoacQWEMnwxNmcTe/xxcH9\n" +
            "RdnLiCf4fQHiFgxlJtq5v2B4dp+rRAwaX+lU4p5OLh0tYWUff64IrOH2oNo7QdwP\n" +
            "KcfvZfK5P0cZCv3MCO5pbFMCgYAZUQYR0Ccq5AAXzG260Mc9HvCaCnwE/SlUIpqT\n" +
            "QftaSn9YKVb8YRSd5UPuaFpG+l4/1LddTFSrm+72HZvM8Ahi8dWEniS63507DWCY\n" +
            "EyPLOZ5yTVnsVB4ocP6m5Zjw+bUOlEsm52RDc16aLvAjLeotzy1gFxMUdjmuzEdv\n" +
            "mx0ExQKBgQDWRUgIYNPqvhsPVDxlU99KWBxR1mjm27qASCTf8iF3DJNjPGac1QTi\n" +
            "CngiVESF+fBRZnIZPb+2jsOG5AvyOnxgeW10Xk4bn66KpqWaxnTef1PPC9glq8jc\n" +
            "orX5roTZ6mUWwvClowAceGScNz6UApdJXQZ6avVtSU5Plk+JXOkqfw==\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String PUBLIC_RSA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzOvsshbTbyfRldkc2fAu\n" +
            "4OuXHikUiADUj7c1x8eVryj0a7hSwRtTMaVdrBr9UcUtUTN87zEPUeHw1rFWpdb0\n" +
            "SpfvgoOZjj6eAd4O2ZR/ZGADof+9P1zYira5kcyBhjNAr6pBIhEvMUY8x6Z5dVXW\n" +
            "x/AkanrMY9nvanyuXPd7Yxl3mwJlVRe2bQS/9qqJZmfxYXKaYq6adu9kZJ54DYEY\n" +
            "rQIgfBWIZ57HTeN1q5+KnJFF+HFEjwIY6lhQ7a7/PhfRY4m2tkcK2Ekf6Hr6biqR\n" +
            "+AIUR411nH8eTMqznJQLTVIfTdB/I/ggANhXJ/tIoUmlK95VyKlBSi4CjiYqpt8G\n" +
            "0QIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
