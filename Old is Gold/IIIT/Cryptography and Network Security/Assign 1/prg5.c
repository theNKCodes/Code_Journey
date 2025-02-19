#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>

void calModExpo(mpz_t res, mpz_t base_b, mpz_t exp, mpz_t mod)
{
    mpz_t temp;
    mpz_init(temp);

    mpz_set_ui(res, 1);

    while (mpz_cmp_ui(exp, 0) > 0)
    {
        if (mpz_odd_p(exp))
        {
            mpz_mul(res, res, base_b);
            mpz_mod(res, res, mod);
        }
        mpz_div_ui(exp, exp, 2);
        mpz_mul(base_b, base_b, base_b);
        mpz_mod(base_b, base_b, mod);
    }

    mpz_clear(temp);
}

int main(int argc, char *argv[])
{
    if (argc != 4)
    {
        return 1;
    }

    mpz_t a, x, n, res;
    mpz_inits(a, x, n, res, NULL);
    mpz_set_str(a, argv[1], 10);
    mpz_set_str(x, argv[2], 10);
    mpz_set_str(n, argv[3], 10);
    calModExpo(res, a, x, n);

    gmp_printf("%Zd", res);

    mpz_clears(a, x, n, res, NULL);

    return 0;
}
