#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <gmp.h>

void find_ModOrder(const mpz_t base, const mpz_t mods)
{
    mpz_t final, expo;
    mpz_init(final);
    mpz_init_set(expo, base);
    mpz_set_ui(final, 1);
    while (true)
    {
        mpz_t baseRaisedToPowerModulus;
        mpz_init(baseRaisedToPowerModulus);
        mpz_powm_ui(baseRaisedToPowerModulus, expo, mpz_get_ui(final), mods);
        if (mpz_cmp_ui(baseRaisedToPowerModulus, 1) == 0)
        {
            gmp_printf("%Zd", final);
            break;
        }
        mpz_add_ui(final, final, 1);
        mpz_clear(baseRaisedToPowerModulus);
    }
    mpz_clears(final, expo, NULL);
}

int main(int argc, char *argv[])
{
    if (argc != 3)
    {
        return 1;
    }
    mpz_t base, mods;
    mpz_init_set_str(base, argv[1], 10);
    mpz_init_set_str(mods, argv[2], 10);
    find_ModOrder(base, mods);
    mpz_clears(base, mods, NULL);
    return 0;
}
