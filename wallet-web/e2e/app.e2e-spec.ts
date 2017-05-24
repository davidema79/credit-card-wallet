import { CreditCardWalletPage } from './app.po';

describe('credit-card-wallet App', () => {
  let page: CreditCardWalletPage;

  beforeEach(() => {
    page = new CreditCardWalletPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
