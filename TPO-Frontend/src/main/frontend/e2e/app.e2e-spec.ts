import { TPOFrontendPage } from './app.po';

describe('tpo-frontend App', () => {
  let page: TPOFrontendPage;

  beforeEach(() => {
    page = new TPOFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
