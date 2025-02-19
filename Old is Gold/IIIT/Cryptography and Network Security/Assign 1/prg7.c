#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>

void findCongruenceSolution(int argc, char *argv[])
{
    if (argc != 4)
    {
        return 1;
    }
    mpz_t a, b, m;
    mpz_inits(a, b, m, NULL);
    mpz_set_str(a, argv[1], 10);
    mpz_set_str(b, argv[2], 10);
    mpz_set_str(m, argv[3], 10);
    mpz_t gcd;
    mpz_init(gcd);
    mpz_gcd(gcd, a, m);
    if (mpz_divisible_p(b, gcd) == 0)
    {
        printf("N\n");
    }
    else
    {
        printf("Y ");
        gmp_printf("%Zd ", gcd);
        mpz_divexact(b, b, gcd);
        mpz_divexact(m, m, gcd);
        mpz_invert(a, a, m);
        mpz_mul(a, a, b);
        mpz_mod(a, a, m);
        gmp_printf("%Zd", a);
    }
    mpz_clear(gcd);
    mpz_clears(a, b, m, NULL);
}
int main(int argc, char *argv[])
{
    findCongruenceSolution(argc, argv);
    return 0;
}
