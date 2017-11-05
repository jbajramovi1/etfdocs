import React from 'react';

const Cover = () => {
    return (
        <section id="cover">
            <div className="container">
                <div class="col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
                    <div className="cover-text">
                        <img src={require('./img/cover-logo.png')} /><br />
                        University platform for document sharing and collaboration
                    </div>
                    <a href="#" className="cover-button">
                        Access platform
                    </a>
                </div>
            </div>
        </section>
    );
};

export default Cover;