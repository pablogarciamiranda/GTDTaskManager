import { Sdi3N5CliRESTAngularPage } from './app.po';

describe('sdi3-n5-cli-rest-angular App', function() {
  let page: Sdi3N5CliRESTAngularPage;

  beforeEach(() => {
    page = new Sdi3N5CliRESTAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
