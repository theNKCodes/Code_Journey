#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>

void ext_euclidean_mpz(mpz_t gcd, mpz_t x, mpz_t y, mpz_t a, mpz_t b)
{
    if (mpz_cmp_ui(b, 0) == 0)
    {
        mpz_set(gcd, a);
        mpz_set_ui(x, 1);
        mpz_set_ui(y, 0);
        return;
    }
    mpz_t q, r, x1, y1;
    mpz_inits(q, r, x1, y1, NULL);
    mpz_fdiv_qr(q, r, a, b);
    ext_euclidean_mpz(gcd, x1, y1, b, r);
    mpz_set(x, y1);
    mpz_set(y, x1);
    mpz_mul(q, q, y1);
    mpz_sub(y, x1, q);
    mpz_clears(q, r, x1, y1, NULL);
}

int main(int argc, char *argv[])
{

    if (argc != 3)
    {
        return 1;
    }
    mpz_t a, b, gcd, x, y;
    mpz_inits(a, b, gcd, x, y, NULL);
    mpz_init_set_str(a, argv[1], 10);
    mpz_init_set_str(b, argv[2], 10);
    ext_euclidean_mpz(gcd, x, y, a, b);
    gmp_printf("%Zd %Zd", x, y);
    mpz_clears(a, b, gcd, x, y, NULL);
    return 0;
}
