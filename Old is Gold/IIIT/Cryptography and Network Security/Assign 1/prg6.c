#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>

void MultiplicativeInverse(mpz_t a, mpz_t m)
{
    mpz_t gcd, invs;
    mpz_inits(gcd, invs, NULL);
    mpz_gcd(gcd, a, m);
    if (mpz_cmp_ui(gcd, 1) != 0)
    {
        printf("N\n");
    }
    else
    {
        printf("Y ");
        mpz_invert(invs, a, m);
        gmp_printf("%Zd", invs);
    }
    mpz_clears(gcd, invs, NULL);
}

int main(int argc, char *argv[])
{
    if (argc != 3)
    {
        return 1;
    }
    mpz_t a, m;
    mpz_inits(a, m, NULL);
    mpz_set_str(a, argv[1], 10);
    mpz_set_str(m, argv[2], 10);
    MultiplicativeInverse(a, m);
    mpz_clears(a, m, NULL);

    return 0;
}
