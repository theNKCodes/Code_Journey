#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>

void RRSM(int argc, char *argv[])
{
    if (argc != 2)
    {
        return 1;
    }

    mpz_t m;
    mpz_init_set_str(m, argv[1], 10);
    mpz_t a, gcd;
    mpz_init(a);
    mpz_init(gcd);
    int ctr = 0;

    for (mpz_set_ui(a, 1); mpz_cmp(a, m) < 0; mpz_add_ui(a, a, 1))
    {
        mpz_gcd(gcd, a, m);
        if (mpz_cmp_ui(gcd, 1) == 0)
        {
            gmp_printf("%Zd ", a);
            ctr++;
        }
    }
    printf("%d", ctr);

    mpz_clears(a, gcd, NULL);
    mpz_clear(m);
}
int main(int argc, char *argv[])
{
    RRSM(argc, argv);
    return 0;
}
