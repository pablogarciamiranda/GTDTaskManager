import { browser, element, by } from 'protractor';

export class Sdi3N5CliRESTAngularPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
}
